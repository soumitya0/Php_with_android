package com.example.php1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Model> models;


    public Adapter(Context context, ArrayList<Model> models)
    {
        this.context = context;
        this.models = models;
    }


    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView= View.inflate(context, R.layout.customlayout, null);
        }

        TextView id=convertView.findViewById(R.id.tv_id);
        TextView username=convertView.findViewById(R.id.tv_password);
        TextView password=convertView.findViewById(R.id.tv_userName);


        Model model=models.get(position); // ArrayList<Model> models   Model represent Model.java

        //name.setText(model.getName());

        //incercari.setText(Integer.toString(valIncercari));
        id.setText(Integer.toString(model.getId()));
        username.setText(model.getUsername());
        password.setText(model.getPassword());



/*public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView etID=( TextView)myView.findViewById(R.id.etID);
            etID.setText( String.valueOf( s.ID));
            TextView etUserName=( TextView)myView.findViewById(R.id.etUserName);
            etUserName.setText(s.UserName);
            TextView etPassword=( TextView)myView.findViewById(R.id.etPassword);
            etPassword.setText(s.Password);
            return myView;
        }
*/

        return convertView;

    }

}
