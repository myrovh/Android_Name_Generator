package myrovh.namegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //UI Properties
    private TextInputEditText firstNameText;
    private TextInputEditText surnameText;
    private TextInputEditText motherNameText;
    private TextInputEditText birthplaceText;
    private TextInputEditText bandText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get UI Variables
        firstNameText = (TextInputEditText) findViewById(R.id.insertFirstName);
        surnameText = (TextInputEditText) findViewById(R.id.insertSurname);
        motherNameText = (TextInputEditText) findViewById(R.id.insertMothersName);
        birthplaceText = (TextInputEditText) findViewById(R.id.insertBirthplace);
        bandText = (TextInputEditText) findViewById(R.id.insertBand);
    }

    public void SubmitButtonPressed(View v) {
        String name = firstNameText.getText().toString();
        String surname = surnameText.getText().toString();
        String mother = motherNameText.getText().toString();
        String place = birthplaceText.getText().toString();
        String band = bandText.getText().toString();
        boolean isValidInputs = true;

        //region Input Validation
        if (name.length() < 3) {
            firstNameText.setError("Must contain at least 3 characters");
            isValidInputs = false;
        }
        if (surname.length() < 2) {
            surnameText.setError("Must contain at least 2 characters");
            isValidInputs = false;
        }
        if (mother.length() < 2) {
            motherNameText.setError("Must contain at least 2 characters");
            isValidInputs = false;
        }
        if (place.length() < 3) {
            birthplaceText.setError("Must contain at least 3 characters");
            isValidInputs = false;
        }
        //endregion

        //Start view activity if no errors
        if (isValidInputs) {
            Intent i = new Intent(this, ViewNameActivity.class);
            Name n = new Name(name, surname, mother, place, band);
            i.putExtra("name", n);
            startActivity(i);
        }
    }
}
