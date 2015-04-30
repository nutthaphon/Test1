package fragments.android.example.com.test1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    void setText(int id) {
        TextView textView1 = (TextView) getView().findViewById(R.id.textView1);
        String str;
        switch (id) {
            case 1 : str = "Stringgggggggggggggg 111111111"; break;
            case 2 : str = "Stringgggggggggggggg 222222222"; break;
            case 3 : str = "Stringgggggggggggggg 333333333"; break;
            case 4 : str = "Stringgggggggggggggg 444444444"; break;
            case 5 : str = "Stringgggggggggggggg 555555555"; break;
            default: str = "";
        }

        textView1.setText(str);
    }

}
