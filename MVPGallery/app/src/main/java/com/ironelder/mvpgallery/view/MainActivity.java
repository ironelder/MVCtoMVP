package com.ironelder.mvpgallery.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ironelder.mvpgallery.R;
import com.ironelder.mvpgallery.component.adapter.ImageRecyclerViewAdapter;
import com.ironelder.mvpgallery.data.source.ImageDataSourceStorage;
import com.ironelder.mvpgallery.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BaseView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ImageRecyclerViewAdapter imageAdapter;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageAdapter = new ImageRecyclerViewAdapter(this);
        recyclerView.setAdapter(imageAdapter);
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.setImageAdapterModel(imageAdapter);
        mainPresenter.setImageAdapterView(imageAdapter);
        mainPresenter.setImageData(ImageDataSourceStorage.getInstance());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter.loadItems(this, false);
    }

    @Override
    public void showImageTitle(String title) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_reload) {
            mainPresenter.loadItems(this, true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
