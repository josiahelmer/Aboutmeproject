package ctec.aboutmeproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;
import android.app.Activity;
import android.widget.SeekBar;



public class VideogameActivity extends Activity implements Runnable
{
    private Button HomeButton;
    private RelativeLayout VideogameLayout;
    private Button startbutton;
    private Button stopbutton;
    private Button pausebutton;
    private MediaPlayer soundPlayer;
    private SeekBar SoundSeekBar;
    private Thread soundThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videogame);

        startbutton = (Button) findViewById(R.id.playbutton);
        pausebutton = (Button) findViewById(R.id.pausebutton);
        stopbutton = (Button) findViewById(R.id.stopbutton);
        SoundSeekBar = (SeekBar) findViewById(R.id.SoundSeekBar);
        soundPlayer = MediaPlayer.create(this.getBaseContext(), R.raw.warneverchanges);
        HomeButton = (Button) findViewById(R.id.HomeVideogameButton);
        VideogameLayout = (RelativeLayout) findViewById(R.id.VideogameLayout);

        setupListeners();

        soundThread = new Thread(this);
        soundThread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_videogame, menu);
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
            //Lets the button take you back to the home screen
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
        //Starts the sound player
        startbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                soundPlayer.start();
            }
        });
        pausebutton.setOnClickListener(new View.OnClickListener()
        //Pauses the sound player
        {
            @Override
            public void onClick(View v)
            {
                soundPlayer.pause();
            }
        });
        stopbutton.setOnClickListener(new View.OnClickListener()
        //stops the sound player so you can restart it
        {
            @Override
            public void onClick(View v)
            {
                soundPlayer.stop();
                soundPlayer = MediaPlayer.create(getBaseContext(), R.raw.warneverchanges);
            }
        });
        SoundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            //Lets the User interact with the seekbar
        {
            @Override
            public void onStopTrackingTouch(SeekBar SeekBar)
            {

            }

            @Override
            public void onStartTrackingTouch(SeekBar SeekBar)
            {

            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if (fromUser)
                {
                    soundPlayer.seekTo(progress);
                }
            }

        });

    }
    @Override
    public void run()
            //Makes the runner implementation work
    {
        int currentPosition = 0;
        int soundTotal = soundPlayer.getDuration();
        SoundSeekBar.setMax(soundTotal);

        while (soundPlayer != null && currentPosition < soundTotal)
        {
            try
            {
                Thread.sleep(300);
                currentPosition = soundPlayer.getCurrentPosition();
            }
            catch(InterruptedException soundException)
            {
                return;
            }
            catch(Exception otherException)
            {
                return;
            }
            SoundSeekBar.setProgress(currentPosition);
        }
    }

}
