package ctec.aboutmeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class AboutmeActivity extends AppCompatActivity {
    private Button WritingButton;
    private Button VideoGamesButton;
    private Button WorkButton;
    private Button SchoolButton;
    private Button FriendsButton;
    private RelativeLayout HomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        WritingButton = (Button) findViewById(R.id.WritingButton);
        VideoGamesButton = (Button) findViewById(R.id.videoGamesButton);
        WorkButton = (Button) findViewById(R.id.WorkButton);
        SchoolButton = (Button) findViewById(R.id.SchoolButton);
        FriendsButton = (Button) findViewById(R.id.FriendsButton);
        HomeLayout = (RelativeLayout) findViewById(R.id.HomeLayout);

        setupListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aboutme, menu);
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
        WritingButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View buttonView)
            {
                Intent changeScreen = new Intent(buttonView.getContext(), WritingActivity.class);
                startActivityForResult(changeScreen, 0);
            }
        });


        VideoGamesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View buttonView)
            {
                Intent changeScreen = new Intent(buttonView.getContext(), VideogameActivity.class);
                startActivityForResult(changeScreen, 0);
            }
        });
        WorkButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View buttonView)
            {
                Intent changeScreen = new Intent(buttonView.getContext(), WorkActivity.class);
                startActivityForResult(changeScreen, 0);
            }
        });
    }
}