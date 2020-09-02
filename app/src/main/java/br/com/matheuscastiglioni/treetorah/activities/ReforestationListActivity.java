package br.com.matheuscastiglioni.treetorah.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.matheuscastiglioni.treetorah.R;
import br.com.matheuscastiglioni.treetorah.adapters.ListAdapter;
import br.com.matheuscastiglioni.treetorah.daos.ReforestationDAO;
import br.com.matheuscastiglioni.treetorah.models.Reforestation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReforestationListActivity extends AppCompatActivity {

    @BindView(R.id.reforestationList_lvReforestation)
    ListView lvReforestation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reforestation_list);
        ButterKnife.bind(this);

        setTitle(R.string.reforestation_list_title);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ReforestationDAO dao = new ReforestationDAO(this);
        List<Reforestation> reforestations = dao.getAll();

        this.lvReforestation.setAdapter(new ListAdapter(reforestations, this, getWindow()));
    }

    @OnClick(R.id.reforestationList_btnAdd)
    public void goToForm() {
        startActivity(new Intent(this, ReforestationFormActivity.class));
    }

}
