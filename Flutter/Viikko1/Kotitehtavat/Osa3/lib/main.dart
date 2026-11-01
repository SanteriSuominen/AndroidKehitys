import 'package:flutter/material.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatefulWidget {
  const MainApp({super.key});

  @override
  State<MainApp> createState() => _MainAppState();
}

class _MainAppState extends State<MainApp> {
  int count = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Colors.indigo,
        ),
      ),
      home: Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text('Laskuri'),
              Text(
                '$count',
                style: TextStyle(
                  fontSize: 56,
                  fontWeight: FontWeight.bold,
                  color: Colors.indigo,
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  FilledButton(
                    onPressed: () {
                      setState(() {
                        count++;
                      });
                    },
                    child: Text('Lisää'),
                  ),
                  SizedBox(width: 12),
                  FilledButton(
                    onPressed: () {
                      setState(() {
                        count--;
                      });
                    },
                    child: Text('vähennä'),
                  ),
                  SizedBox(width: 12),
                ],
              ),
              FilledButton(
                onPressed: () {
                  setState(() {
                    count = 0;
                  });
                },
                child: Text('Nollaa'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
