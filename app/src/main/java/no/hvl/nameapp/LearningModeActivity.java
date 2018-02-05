package no.hvl.nameapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import no.hvl.nameapp.data.Person;
import no.hvl.nameapp.data.PersonDB;

public class LearningModeActivity extends AppCompatActivity {

    private PersonDB db = PersonDB.getInstance();
    private ArrayList<Person> guessed;
    private Integer score = 0;
    private Person currentPerson;
    private ImageView imageView;
    private TextView scoreCountView;
    private EditText guessText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_mode);
        startNewGame();
    }

    private void startNewGame() {
        currentPerson = db.getRandomPerson();
        score = 0;
        scoreCountView = findViewById(R.id.textView_score);
        scoreCountView.setText(score.toString());
        imageView = findViewById(R.id.imageView4);
        imageView.setImageURI(currentPerson.getImageURI());
        guessed = new ArrayList<>();
        guessed.add(currentPerson);
    }

    public void guess(View view) {
        guessText = findViewById(R.id.editText_guess);
        String guess = guessText.getText().toString();
        if (isGuessCorrect(currentPerson, guess)) {
            score++;
            Toast.makeText(getApplicationContext(), R.string.correct, Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(getApplicationContext(), "Wrong, that was " + currentPerson.getName() + "!", Toast.LENGTH_SHORT).show();
        }

        if (isGameover()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Game Over")
                    .setMessage("Game over " + score + "/" + db.count())
                    .setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            startNewGame();
                        }
                    })
                    .setNegativeButton("Return to Menu", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();
        } else {
            while (guessed.contains(currentPerson)) {
                currentPerson = db.getRandomPerson();
            }
            update();
        }


    }

    private void update() {
        guessed.add(currentPerson);
        changeImage(getApplicationContext(),imageView,currentPerson.getImageURI());
        scoreCountView.setText(score.toString());
        guessText.setText("");
    }

    private boolean isGameover() {
        return (guessed.size() >= db.count());
    }

    private boolean isGuessCorrect(Person currentPerson, String guess) {
        return (guess.toLowerCase()).equals(currentPerson.getName().toLowerCase());
    }

    private void changeImage(Context c,final ImageView v,final Uri newImage) {
         final Animation out = AnimationUtils.loadAnimation(c, android.R.anim.slide_out_right);
         final Animation in  = AnimationUtils.loadAnimation(c, android.R.anim.slide_in_left);
         out.setAnimationListener(new Animation.AnimationListener() {
            @Override public void onAnimationStart(Animation animation) {}
            @Override public void onAnimationRepeat(Animation animation) {}
            @Override public void onAnimationEnd(Animation animation) {
                v.setImageURI(newImage);
                in.setAnimationListener(new Animation.AnimationListener() {
                    @Override public void onAnimationStart(Animation animation) {}
                    @Override public void onAnimationRepeat(Animation animation) {}
                    @Override public void onAnimationEnd(Animation animation) {}
                });
                v.startAnimation(in);
            }
        });
        v.startAnimation(out);
    }
    }


