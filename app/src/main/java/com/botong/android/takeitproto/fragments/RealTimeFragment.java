package com.botong.android.takeitproto.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.botong.android.takeitproto.R;
import com.botong.android.takeitproto.realtime.CustomAdapter;
import com.botong.android.takeitproto.realtime.ListData;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RealTimeFragment extends Fragment {


    public RealTimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_real_time, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listViewActRealTime);
        ArrayList<ListData> listDataArray = new ArrayList<>();

        ListData dummy01 = new ListData("김부장 우리 강아지 정말 고마워 덕분에 열심히 할게", 15);
        ListData dummy02 = new ListData("내 꿈을 찾기 위해 난 나가야만 해", 10);
        ListData dummy03 = new ListData("어디에 내가 가야 할 곳이 있는가? ㅠㅠ", 19);
        ListData dummy04 = new ListData("이제는 더이상 함께할 수 없어. 이제 떠나야할 시간이야.", 22);
        ListData dummy05 = new ListData("결심만 삼만번째 이제 진짜 나간다고 할 수 있다면 얼마나 좋을지...", 33);

        listDataArray.add(dummy01);
        listDataArray.add(dummy02);
        listDataArray.add(dummy03);
        listDataArray.add(dummy04);
        listDataArray.add(dummy05);

        CustomAdapter customAdapter = new CustomAdapter(inflater.getContext(), R.layout.list_item_real_time, listDataArray);

        listView.setAdapter(customAdapter);

        return view;
    }

}
