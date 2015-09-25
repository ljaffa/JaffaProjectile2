package jaffa.projectile2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private TextView angle;
    private TextView velocity;
    private TextView time;

    private EditText editAngle;
    private EditText editVelocity;
    private EditText editTime;

    private Button button;

    private TextView xy;

    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(image);

        angle = (TextView) findViewById(R.id.angleId);
        velocity = (TextView) findViewById(R.id.velocityId);
        time = (TextView) findViewById(R.id.timeId);
        xy = (TextView) findViewById(R.id.xy);

        editAngle = (EditText) findViewById(R.id.editAngleId);
        editVelocity = (EditText) findViewById(R.id.editVelocityId);
        editTime = (EditText) findViewById(R.id.editTimeId);

        button = (Button) findViewById(R.id.buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer = "(" + getX() + ", " + getY() + ")";
                xy.setText(answer);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public double getX(){
        double editAngleDouble = Double.parseDouble(editAngle.getText().toString());
        double editVelocityDouble = Double.parseDouble(editVelocity.getText().toString());
        double editTimeDouble = Double.parseDouble(editTime.getText().toString());

        double angleRadians = Math.toRadians(editAngleDouble);
        double sinAngle = Math.sin(angleRadians);

        double x = sinAngle * editVelocityDouble * editTimeDouble;
        return x;
    }

    public double getY(){
        double editAngleDouble = Double.parseDouble(editAngle.getText().toString());
        double editVelocityDouble = Double.parseDouble(editVelocity.getText().toString());
        double editTimeDouble = Double.parseDouble(editTime.getText().toString());

        double angleRadians = Math.toRadians(editAngleDouble);
        double cosAngle = Math.cos(angleRadians);
        double y = cosAngle * editVelocityDouble * editTimeDouble - (.5 * 9.8 * editTimeDouble * editTimeDouble);
        return y;
    }
}
