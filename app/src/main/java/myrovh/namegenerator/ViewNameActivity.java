package myrovh.namegenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewNameActivity extends AppCompatActivity {
    TextView nameLabel;
    Name displayedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_name);

        //Get UI Variables
        nameLabel = (TextView) findViewById(R.id.generatedNameLabel);

        //Get Intent and Parcel
        Intent i = getIntent();
        displayedName = (Name) i.getParcelableExtra("name");

        //Set UI Elements
        nameLabel.setText(displayedName.GetGeneratedName());
    }
}
