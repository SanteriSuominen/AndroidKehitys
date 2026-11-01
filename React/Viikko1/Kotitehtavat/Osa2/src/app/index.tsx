import { useState } from "react";
import { Button, StyleSheet, Text, View } from "react-native";

export default function Index() {
  const [count, setCount] = useState(0);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Laskuri</Text>
      <View style={{ flexDirection: "row", gap: 12 }}>
        <Button
          title="Lisää"
          onPress={() => setCount((current) => current + 1)}
        />
        <Button
          title="Vähennä"
          onPress={() => setCount((current) => current - 1)}
        />
      </View>
      <Button title="Nollaa" onPress={() => setCount(0)} />

      <Text style={styles.count}>{count}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
  },
  title: {
    fontSize: 28,
    fontWeight: "bold",
  },
  count: {
    fontSize: 48,
  },
});
