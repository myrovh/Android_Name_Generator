package myrovh.namegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //UI Properties
    private TextInputLayout firstNameLayout;
    private TextInputLayout surnameLayout;
    private TextInputLayout motherNameLayout;
    private TextInputLayout birthplaceLayout;
    private TextInputLayout bandLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get UI Variables
        firstNameLayout = (TextInputLayout) findViewById(R.id.layoutFirstName);
        surnameLayout = (TextInputLayout) findViewById(R.id.layoutSurname);
        motherNameLayout = (TextInputLayout) findViewById(R.id.layoutMothersName);
        birthplaceLayout = (TextInputLayout) findViewById(R.id.layoutBirthplace);
        bandLayout = (TextInputLayout) findViewById(R.id.layoutBand);
    }

    public void SubmitButtonPressed(View v) {
        String name = firstNameLayout.getEditText().getText().toString();
        String surname = surnameLayout.getEditText().getText().toString();
        String mother = motherNameLayout.getEditText().getText().toString();
        String place = birthplaceLayout.getEditText().getText().toString();
        String band = bandLayout.getEditText().getText().toString();
        boolean isValidInputs = true;

        //region Input Validation
        if (name.length() < 3) {
            firstNameLayout.setError("Must contain at least 3 characters");
            isValidInputs = false;
        } else {
            firstNameLayout.setError(null);
        }
        if (surname.length() < 2) {
            surnameLayout.setError("Must contain at least 2 characters");
            isValidInputs = false;
        } else {
            surnameLayout.setError(null);
        }
        if (mother.length() < 2) {
            motherNameLayout.setError("Must contain at least 2 characters");
            isValidInputs = false;
        } else {
            motherNameLayout.setError(null);
        }
        if (place.length() < 3) {
            birthplaceLayout.setError("Must contain at least 3 characters");
            isValidInputs = false;
        } else {
            birthplaceLayout.setError(null);
        }
        if (band.length() < 1) {
            bandLayout.setError("Must contain at least 1 character");
            isValidInputs = false;
        } else {
            bandLayout.setError(null);
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
