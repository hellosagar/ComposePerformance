### Article
Links will be mentioned here soon :)

### Idea
This project explains how to remove unwanted recompositions and it contains isolated examples that will help you to understand them and then apply the optimizations in your project :)

### Where to start
Run the app and it contains a lot of button(s). Now what does that mean? Each item in a column shows a concept, and within that item, there are multiple buttons. The first button will take you to the buggy code and the following button is the possible solution to fix that buggy code. 
<img width="310" alt="266143856-99231955-aae8-4089-b6c4-09f342b3c7b6" src="https://github.com/hellosagar/ComposePerformance/assets/50016799/d1ce8460-900f-43f8-98d1-e3b214e26acd">

 

### How to observe recompositions
1. Run the app
2. Open a screen with buggy code eg. `CollectionExample`
3. Open layout inspector, 
4. Observe the recompositions from buggy class
5. Now open the class with the correct approach
6. Observe the recompositions 
7. You will see the difference i.e less recompositions in the correct approach, thats its ✨
 
Video Sample doing the steps above


![266147274-c696f731-5e8a-4345-ace4-e018a83d0e8c](https://github.com/hellosagar/ComposePerformance/assets/50016799/7ca1ca6f-2ebe-4a0a-aaae-ae3d4a20ae4e)




### What the package structure
Each concept is a group by a package within which it contains one bug code and others are the possible solutions. In the example below
- `CollectionExample`: Buggy code with unwanted recompositions
- `CollectionExampleSolutionAnnotation`: Solution #1
- `CollectionSolutionKotlinx`: Solution #2
<img width="419" alt="266144011-fee24b53-1dda-4ff1-ba6d-c4e76538499a" src="https://github.com/hellosagar/ComposePerformance/assets/50016799/762ca114-e7d5-44ca-b1f5-d6b1e0b68d3a">


### What's inside class
In each class, it contains a class header that explains the `ISSUE` and the possible `SOLUTIONS`
<img width="712" alt="266145111-ed067a11-be6c-4190-9fae-4fa16b64a862" src="https://github.com/hellosagar/ComposePerformance/assets/50016799/de7683d9-41eb-4be3-a6da-3a60bc257a27">

Special Thanks to [PhilippNowak96](https://github.com/PhilippNowak96) [hi-manshu](https://github.com/hi-manshu), [PatilShreyas](https://github.com/PatilShreyas) and [skydoves](https://github.com/skydoves) for helping me during the process 🙏

