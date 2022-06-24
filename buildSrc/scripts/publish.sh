#!/usr/bin/env sh

# format of a release tag:
# releases/{path/of/module/to/release}/v0.0.1/{build-flavor}
# {path/of/module/to/release}: path to the module to release in settings.gradle file, but using "/"
# to separate instead of ":". Leave it empty if you want to publish all modules in the project.
# {build-flavor}: the build flavor for publishing module. Leave it empty if you want to publish
# the default flavor (`assembleRelease`)
#
# Usage:
# Eg 1:
# publish.sh releases/terra/terra-core/terra-core-android/v0.0.1
# this will execute command gradle :terra:terra-core:terra-core-android:publish without any product
# flavor ("assembleRelease") and version is 0.0.1
#
# Eg 2:
# publish.sh releases/terra/terra-core/terra-core-android/v0.0.1-stage/stage
# this will execute command gradle :terra:terra-core:terra-core-android:publish with product flavor
# is stage ("assembleStageRelease") and version is 0.0.1-stage

# Regex for publish version
VERSION_PART_REGEX="^[v]?([0-9]+)\.([0-9]+)\.([0-9]+)(-([^\+]+)|.{0})(\+(.+)|.{0})$"

TRUE=0
FALSE=1

isVersionPart() {
  if [[ $1 =~ $VERSION_PART_REGEX ]]; then
    return $TRUE
  else
    return $FALSE
  fi
}

IFS='/' read -r -a parts <<<"$1"

parts_length=${#parts[@]}
last_part=${parts[$parts_length - 1]}
second_last_part=${parts[$parts_length - 2]}

if [ "${parts[0]}" == "releases" ]; then
  publish_version=""
  publish_flavor=""
  module=""

  if isVersionPart $last_part; then
    publish_version=$last_part
  elif isVersionPart $second_last_part; then
    publish_version=$second_last_part
    publish_flavor=$last_part
  fi

  for i in "${parts[@]}"; do
    if [ "$i" == "$publish_version" ]; then
      break
    fi

    if [ "$i" != "releases" ]; then
      module="$module:$i"
    fi
  done

  export PUBLISH_VERSION="${publish_version[@]:1}"
  export PUBLISH_MODULE="$module"
  export PUBLISH_FLAVOR=$publish_flavor

  if [ "$module" == "" ]; then
    export PUBLISH_COMMAND="publish"
  else
    export PUBLISH_COMMAND="$module:publish"
  fi

  echo "publish flavor $PUBLISH_FLAVOR"
  echo "execute gradle $PUBLISH_COMMAND"
  echo "version $PUBLISH_VERSION"
  ./gradlew "$PUBLISH_COMMAND"
fi
