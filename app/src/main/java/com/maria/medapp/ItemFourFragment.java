package com.maria.medapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemFourFragment extends Fragment {

    ListView listView;

    public ItemFourFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemFourFragment.
     */

    public static ItemFourFragment newInstance() {
        ItemFourFragment fragment = new ItemFourFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//         View view = inflater.inflate(R.layout.fragment_item_four, container, false);
//          listView = (ListView) view.findViewById(R.id.listview);
//        CustomAdapter adapter = new CustomAdapter(this);
//        listView.setAdapter(adapter);
//        final ListView listView=(ListView)getActivity().findViewById(R.id.listview);
//        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
//                Intent intent;
//                intent = new Intent(getActivity(), Main2Activity.class);
//                intent.putExtra("Position", pos);
//
//                startActivity(intent);
//            }
//        });
//
//        return view;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_four, container, false);

        String[] menuItems = {"Maria", "Kleo", "Sanda", "Cristina"};
        String[] descritipion = {"Eye doctor", "Eye doctor", "Eye doctor", "Eye doctor"};
        Integer[] image = {R.drawable.person, R.drawable.person1, R.drawable.person, R.drawable.person};

        ListView listView = (ListView) view.findViewById(R.id.listview);

        ArrayAdapter<String> listAdapterView = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listView.setAdapter(listAdapterView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0)
                { Intent intent = new Intent(getActivity(),Main3Activity.class);
                    startActivity(intent);
                }
                else if (position == 1)
                {
                    Intent intent1 = new Intent(getActivity(),Main3Activity.class);
                    startActivity(intent1);
                }
                else if (position == 2)
                {
//                    Toast.makeText(getActivity(), "You clicked on 3", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getActivity(),Main3Activity.class);
                    startActivity(intent2);
                }
                else if (position == 3) {
                    Intent intent3 = new Intent(getActivity(), Main3Activity.class);
                    startActivity(intent3);
                }
            }
        });
        return view;
//

    }
}
