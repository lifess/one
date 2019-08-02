package example.ss.com.stos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.imageView)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @butterknife.OnClick({R.id.textView, R.id.button, R.id.imageView})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.textView:
                Toast.makeText(this, "So take aim and fire away...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Toast.makeText(this, "So then when I'm finished,,,", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView:
                Toast.makeText(this, "你的笑脸，是个不错的靶子！！！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
