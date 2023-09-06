# ComposePerformance
This project is the sample project from the 3 article series for the compose performance.

### Idea
This project explains how to remove unwanted recompositions and it contains isolated examples that will help you to understand them and then apply the optimizations in your project :)

### Where to start
Run the app and it contains a lot of button(s). Now what does that mean? Each item in a column shows a concept, and within that item, there are multiple buttons. The first button will take you to the buggy code and the following button is the possible solution to fix that buggy code. 

<img width="310" alt="Screenshot 2023-09-06 at 11 19 41 PM" src="https://github.com/hellosagar/ComposePerformance/assets/50016799/99231955-aae8-4089-b6c4-09f342b3c7b6">


### What the package structure
Each concept is a group by a package within which it contains one bug code and others are the possible solutions. In the example below
- `CollectionExample`: Buggy code with unwanted recompositions
- `CollectionExampleSolutionAnnotation`: Solution #1
- `CollectionSolutionKotlinx`: Solution #2
<img width="419" alt="Screenshot 2023-09-06 at 11 20 37 PM" src="https://github.com/hellosagar/ComposePerformance/assets/50016799/fee24b53-1dda-4ff1-ba6d-c4e76538499a">

### What's inside class
In each class, it contains a class header that explains the `ISSUE` and the possible `SOLUTIONS`
<img width="712" alt="Screenshot 2023-09-06 at 11 26 04 PM" src="https://github.com/hellosagar/ComposePerformance/assets/50016799/ed067a11-be6c-4190-9fae-4fa16b64a862">

