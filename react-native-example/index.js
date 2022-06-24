import React from 'react';
import { AppRegistry, StyleSheet, View, Text, Image } from 'react-native';
import ProductDetail from './ProductDetail';

const App = (props) => {
  const scenario = "Scenario: " + props.Scenario
  const tokenId = scenario + "\n" + (props.terraIdToken ? "Exchanged Token: Yes" : "Exchanged Token: No");

  return (
    <View style={styles.container}>
      <Text style={styles.baseText}>{tokenId}</Text>
      <ProductDetail />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
  },
  idTokenContainer: {
    margin: 16,
  },
  idTokenLabel: {
    fontWeight: 'bold',
    fontSize: 15,
    color: 'black',
  },
});

export default App;

// Module name
AppRegistry.registerComponent('RNMain', () => App);
