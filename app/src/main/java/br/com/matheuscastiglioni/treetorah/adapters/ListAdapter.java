package br.com.matheuscastiglioni.treetorah.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.matheuscastiglioni.treetorah.R;
import br.com.matheuscastiglioni.treetorah.models.Reforestation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends BaseAdapter {

    @BindView(R.id.listAdapter_tvYear)
    TextView listAdapter_tvYear;
    @BindView(R.id.listAdapter_tvState)
    TextView listAdapter_tvState;
    @BindView(R.id.listAdapter_tvTreesCutted)
    TextView listAdapter_tvTreesCutted;
    @BindView(R.id.listAdapter_tvVolume)
    TextView listAdapter_tvVolume;
    @BindView(R.id.listAdapter_tvTreesReplace)
    TextView listAdapter_tvTreesReplace;
    @BindView(R.id.listAdapter_tvValueToPay)
    TextView listAdapter_tvValueToPay;

    private final List<Reforestation> reforestations;
    private final Context context;
    private final Window view;

    public ListAdapter(List<Reforestation> reforestations, Context context, Window view) {
        this.reforestations = reforestations;
        this.context = context;
        this.view = view;
    }

    @Override
    public int getCount() {
        return this.reforestations.size();
    }

    @Override
    public Object getItem(int i) {
        return this.reforestations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Reforestation reforestation = this.reforestations.get(i);
        LayoutInflater inflater = LayoutInflater.from(this.context);

        if (view == null) {
            view = inflater.inflate(R.layout.list_adapter, viewGroup, false);
            ButterKnife.bind(this, view);
        }

        this.listAdapter_tvYear.setText(Integer.toString(reforestation.getYear()));
        this.listAdapter_tvState.setText(reforestation.getState());
        this.listAdapter_tvTreesCutted.setText(Integer.toString(reforestation.getTreesCutted()));
        this.listAdapter_tvVolume.setText(Integer.toString(reforestation.getVolume()));
        this.listAdapter_tvTreesReplace.setText(Integer.toString(reforestation.getTreesToReplace()));
        this.listAdapter_tvValueToPay.setText("R$ " + Double.toString(reforestation.getValueToPay()));
        return view;
    }

}
