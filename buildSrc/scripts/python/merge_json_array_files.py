import json
import sys

final = []
for file_name in sys.argv[2:] :
    print(file_name)
    with open(file_name) as file:
        data = json.load(file)
        final.append(data)
        print(final[:])

out_file_name = sys.argv[1]
with open(out_file_name, 'w') as outfile:
    json.dump(final, outfile, indent=4)