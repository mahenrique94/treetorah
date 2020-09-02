package br.com.matheuscastiglioni.treetorah.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.matheuscastiglioni.treetorah.R;
import br.com.matheuscastiglioni.treetorah.daos.ReforestationDAO;
import br.com.matheuscastiglioni.treetorah.models.Reforestation;
import br.com.matheuscastiglioni.treetorah.validators.FormValidator;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReforestationFormActivity extends AppCompatActivity {

    @BindView(R.id.reforestationForm_etYear)
    EditText etYear;
    @BindView(R.id.reforestationForm_etState)
    EditText etState;
    @BindView(R.id.reforestationForm_etTreesCutted)
    EditText etTreesCutted;
    @BindView(R.id.reforestationForm_etVolume)
    EditText etVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reforestation_form);
        ButterKnife.bind(this);

        setTitle(R.string.reforestation_form_title);
    }


    @OnClick(R.id.reforestationForm_btnSave)
    public void save() {
        if (FormValidator.validateField(this.etYear) && FormValidator.validateField(this.etState) && FormValidator.validateField(this.etTreesCutted) && FormValidator.validateField(this.etVolume)) {
            Reforestation newReforestation = new Reforestation(
                    Integer.parseInt(this.etYear.getText().toString()),
                    this.etState.getText().toString(),
                    Integer.parseInt(this.etTreesCutted.getText().toString()),
                    Integer.parseInt(this.etVolume.getText().toString())
            );
            ReforestationDAO dao = new ReforestationDAO(this);
            dao.save(newReforestation);
            onBackPressed();
        }
    }

}
