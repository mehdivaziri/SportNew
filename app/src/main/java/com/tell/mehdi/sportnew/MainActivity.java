package com.tell.mehdi.sportnew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.tell.mehdi.sportnew.model.MainSportDatabase;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //introduction realm
        Realm.init(this);
        realm=Realm.getDefaultInstance();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void addRecord(int id,String name,byte[] image){
        realm.beginTransaction();

        MainSportDatabase mainSportDatabase=realm.createObject(MainSportDatabase.class);
        mainSportDatabase.setIdMain(id);
        mainSportDatabase.setNameMain(name);
        mainSportDatabase.setImageMain(image);

        realm.commitTransaction();
    }

    private void ReedRecord(){
        RealmResults<MainSportDatabase> results=realm.where(MainSportDatabase.class).findAll();

    }

    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }
}
