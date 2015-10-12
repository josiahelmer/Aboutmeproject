package ctec.aboutmeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;

public class SchoolActivity extends AppCompatActivity
    {
    private Button  HomeButton;
    private RelativeLayout SchoolLayout;
    private ImageView SchoolImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        HomeButton = (Button) findViewById(R.id.HomeSchoolButton);
        SchoolLayout = (RelativeLayout) findViewById(R.id.SchoolLayout);
        SchoolImage = (ImageView) findViewById(R.id.SchoolImage);

        setupListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_school, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

      private void setupListeners()
      {
            HomeButton.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View buttonView)
                {
                    Intent returnIntent = new Intent();
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
            });
        }
}
