package com.example.hyunyoungpark.prefrencesexample;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class MainActivityFragment extends Fragment {

    //Create A int constant for total no of question in FLAGS_IN_QUIZ

    //TODO 11) Create a list for quiz
    // private List<String> for flag file names
    // private List<String> for countries in current quiz
    // private Set<String> for world regions in current quiz


    private LinearLayout quizLinearLayout;
    private TextView questionNumberTextView;
    private ImageView flagImageView;
    private LinearLayout[] guessLinearLayouts;
    private TextView answerTextView;
    private SecureRandom random;
    private String correctAnswer;
    private int guessRows;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        random = new SecureRandom();
        fileNameList = new ArrayList<>();
        quizCountriesList = new ArrayList<>();

        random = new SecureRandom();
        fileNameList = new ArrayList<>();
        quizCountriesList = new ArrayList<>();

        quizLinearLayout = (LinearLayout)view.findViewById(R.id.quizLinearLayout);
        questionNumberTextView = (TextView)view.findViewById(R.id.questionNumberTextView);
        flagImageView = (ImageView)view.findViewById(R.id.flagImageView);
        guessLinearLayouts = new LinearLayout[4];
        guessLinearLayouts[0] = (LinearLayout)view.findViewById(R.id.row1LinearLayout);
        guessLinearLayouts[1] = (LinearLayout)view.findViewById(R.id.row2LinearLayout);
        guessLinearLayouts[2] = (LinearLayout)view.findViewById(R.id.row3LinearLayout);
        guessLinearLayouts[3] = (LinearLayout)view.findViewById(R.id.row4LinearLayout);
        answerTextView = (TextView) view.findViewById(R.id.answerTextView);

        questionNumberTextView.setText(getString(R.string.question,1,FLAGS_IN_QUIZ));


        return view;
    }

    public void updateGuessRows(SharedPreferences sharedPreferences) {
        String choices = sharedPreferences.getString(MainActivity.CHOICES, null);
        guessRows = Integer.parseInt(choices) / 2;

        for (LinearLayout layout : guessLinearLayouts)
            layout.setVisibility(View.GONE);

        for (int row = 0; row < guessRows; row++)
            guessLinearLayouts[row].setVisibility(View.VISIBLE);
    }

    public void updateRegions(SharedPreferences sharedPreferences) {
        regionsSet = sharedPreferences.getStringSet(MainActivity.REGIONS,null);
    }

    public void startQuiz() {
        int i=0;
        AssetManager assets = getActivity().getAssets();
        try {
            for (String region : regionsSet) {
                String[] paths = assets.list(region);
                for (String path : paths)
                    fileNameList.add(path.replace(".png", ""));
            }
        }catch (IOException exception) {
            Log.e("IN FLAG QUIZ : ", "Error loading image file names", exception);
        }
        int flagCounter = 1;

        int numberOfFlags = fileNameList.size();
        while (flagCounter <= FLAGS_IN_QUIZ) {
            int randomIndex = random.nextInt(numberOfFlags);
            String filename = fileNameList.get(randomIndex);
            if (!quizCountriesList.contains(filename)) {
                quizCountriesList.add(filename);
                ++flagCounter;
            }
        }
        loadtheflag();
    }
    private void loadtheflag() {
        String nextImage = quizCountriesList.remove(0);
        correctAnswer = nextImage;
        String region = nextImage.substring(0, nextImage.indexOf('-'));

        AssetManager assets = getActivity().getAssets();

        try (InputStream stream =
                     assets.open(region + "/" + nextImage + ".png")) {
            Drawable flag = Drawable.createFromStream(stream, nextImage);
            flagImageView.setImageDrawable(flag);

        }
        catch (IOException exception) {
            Log.e("in the flag quiz ", "Error loading " + nextImage, exception);
        }

        Collections.shuffle(fileNameList);
        int correct = fileNameList.indexOf(correctAnswer);
        fileNameList.add(fileNameList.remove(correct));
        for (int row = 0; row < guessRows; row++) {
            for (int column = 0;
                 column < guessLinearLayouts[row].getChildCount();
                 column++) {
                Button newGuessButton =
                        (Button) guessLinearLayouts[row].getChildAt(column);
                newGuessButton.setEnabled(true);

                String filename = fileNameList.get((row * 2) + column);
                newGuessButton.setText(getCountryName(filename));
            }
        }
        int row = random.nextInt(guessRows);
        int column = random.nextInt(2);
        LinearLayout randomRow = guessLinearLayouts[row];
        String countryName = getCountryName(correctAnswer);
        ((Button) randomRow.getChildAt(column)).setText(countryName);
    }

    private String getCountryName(String name) {
        return name.substring(name.indexOf('-') + 1).replace('_', ' ');
    }
}
