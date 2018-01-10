# Oblig 1: Name-app
### General
The assignment should be delivered in the form of a link to the GitHub-project corresponding to your group. The project should contain an overview document (e.g. README.MD) with the names of all the members of the group and a brief (a few lines) report on the project, e.g. if any special configuration is necessary, how to run the app, etc.

You will give a short **demonstration** of your to the teacher/lab assistant in the **lab on Tuesday, 23rd**. All group members should be there and be able to answer our questions about the app and the source code. If we're not happy with your solution and ask for changes, you have until Thursday to complete them.

### The “Name App”
This should be a small learning app to get to know your fellow students (and teachers, if you have a bad memory) in the class. Your app should offer the possibility to save a collection of pictures and the corresponding names of the people in class. We have three different use cases:

1. List of available names. By choosing a name from the list, we can go to the corresponding picture.
2. Picture gallery. Shows all available pictures; upon selection of a picture shows the corresponding name.
3. Learning mode. The app presents a random picture, and an empty input field. The user has to guess the name and write it into the input field. Then, the app will show whether you guessed the right name or not. The app also counts your score (successes/mistakes), and if you leave learning mode, shows your score.

Implement the “Name App” as an Android application in Android studio!
* The main activity should allow you to choose which of the three modes you want to run.
* One of the use cases should contain functionality to add a new name and picture (e.g. from the camera, or a file/the gallery).
* Your app should have at least your names and pictures of the group "built in" (feel free to use cat-photos; not too large files!).
* From each mode, it should be possible to navigate back to the main menu.
* There is no need to save any information (like the score, or the database) between different runs of the app. We will extend our app to store data on the phone next week, in the next oblig.

### Notes
If you use `Intent.ACTION_GET_CONTENT` to choose an image from the Media Gallery, you can easily open the image through its URI afterwards:
```
InputStream is = context.getContentResolver().openInputStream(imageUri);
Bitmap bitmap = BitmapFactory.decodeStream(is);
```



#skole/dat153