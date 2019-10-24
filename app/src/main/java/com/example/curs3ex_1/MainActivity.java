package com.example.curs3ex_1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Observable;
import java.util.Observer;
import com.example.curs3ex_1.models.Model;
import com.example.curs3ex_1.presenters.Presenter;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener{
    private Button btnCounter1;
    private Button btnCounter2;
    private Button btnCounter3;
    private Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCounter1 = (Button) findViewById(R.id.btnCounter1);
        btnCounter2 = (Button) findViewById(R.id.btnCounter2);
        btnCounter3 = (Button) findViewById(R.id.btnCounter3);
        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);
       // mPresenter = Presenter.getInstance();

        if (savedInstanceState == null) {
            mPresenter = new Presenter();
        } else {
            mPresenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnCounter1:
                mPresenter.buttonClick(0);
                break;
            case R.id.btnCounter2:
                mPresenter.buttonClick(1);
                break;
            case R.id.btnCounter3:
                mPresenter.buttonClick(2);
                break;
        }

    }
    @Override
    public void setButtonText(int btnIndex, int value) {
        switch (btnIndex){
            case 0:
                btnCounter1.setText("Количество = " + value);
                break;
            case 1:
                btnCounter2.setText("Количество = " + value);
                break;
            case 2:
                btnCounter3.setText("Количество = " + value);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.bindView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unbindView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        PresenterManager.getInstance().savePresenter(mPresenter, outState);
    }

}
