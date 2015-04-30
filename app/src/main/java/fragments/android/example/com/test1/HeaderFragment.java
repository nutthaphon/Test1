package fragments.android.example.com.test1;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeaderFragment extends Fragment {

    OnItemSelectedListener headerListener;

    interface OnItemSelectedListener {
        void onItemSelected(int id);
    }

    // ประกาศค่า Listener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            headerListener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenets HeaderFragment.OnItemSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_header, container, false);

        TextView item1 = (TextView) view.findViewById(R.id.item1);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(1);
            }
        });

        TextView item2 = (TextView) view.findViewById(R.id.item2);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(2);
            }
        });
        TextView item3 = (TextView) view.findViewById(R.id.item3);
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(3);
            }
        });
        TextView item4 = (TextView) view.findViewById(R.id.item4);
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(4);
            }
        });
        TextView item5 = (TextView) view.findViewById(R.id.item5);
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(5);
            }
        });
        return view;
    }

    // ทำการ update ข้อมูลใน Detail Fragment
    void updateDetail(int id) {
        // โดยปกติ Java ไม่สามารถอ้างถึง R.id ใน Detail Fragment ได้เอง
        // ต้องให้ Main Activity เข้าช่วย ด้วยการใช้ Interface

       headerListener.onItemSelected(id);

    }

}

