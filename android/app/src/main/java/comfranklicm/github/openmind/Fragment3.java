package comfranklicm.github.openmind;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import comfranklicm.github.openmind.utils.User;

public class Fragment3 extends Fragment {
    View view;
   TextView loginorname;
    TextView username;
    SimpleDraweeView head;
    TextView department;
    TextView tubiao1;
    TextView tubiao2;
    TextView tubiao3;
    View xuxian3;
    LinearLayout active;
    LinearLayout setting;
    LinearLayout aboutme;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	     view = inflater.inflate(R.layout.fg3, container,false);
        initlayout();
		return view;
	}
    private void initlayout() {
        loginorname=(TextView)view.findViewById(R.id.login_name);
        username=(TextView)view.findViewById(R.id.username);
        department=(TextView)view.findViewById(R.id.department);
        xuxian3=view.findViewById(R.id.xuxian3);
        active=(LinearLayout)view.findViewById(R.id.huoyuejilu);
        setting=(LinearLayout)view.findViewById(R.id.settings);
        aboutme=(LinearLayout)view.findViewById(R.id.yuwoxiangguan);
        tubiao1=(TextView)view.findViewById(R.id.fa_signal);
        tubiao2=(TextView)view.findViewById(R.id.fa_cog);
        tubiao3=(TextView)view.findViewById(R.id.fa_commenting_o);
        head = (SimpleDraweeView) view.findViewById(R.id.touxiang);
        try {
            Uri uri = Uri.parse(User.getInstance().getPictureLink());
            head.setImageURI(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tubiao1.setTypeface(FontManager.getTypeface(getContext(), FontManager.FONTAWESOME));
        tubiao2.setTypeface(FontManager.getTypeface(getContext(), FontManager.FONTAWESOME));
        tubiao3.setTypeface(FontManager.getTypeface(getContext(), FontManager.FONTAWESOME));
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyActivity activity = (MyActivity) getActivity();
                activity.transactiontoSetting();
            }
        });
        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyActivity activity = (MyActivity) getActivity();
                activity.transactiontoActiveDegree();
            }
        });
        aboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyActivity activity = (MyActivity) getActivity();
                activity.transactiontoAboutMe();
            }
        });
        if (!User.getInstance().isLogin() && !User.getInstance().isLastLogin()) {
            username.setVisibility(View.GONE);
            active.setVisibility(View.GONE);
            department.setVisibility(View.GONE);
            //xuxian3.setVisibility(View.GONE);
            aboutme.setVisibility(View.GONE);
            loginorname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyActivity activity = (MyActivity) getActivity();
                    activity.transactiontoLogin();
                }
            });
        }else {
            loginorname.setText(User.getInstance().getRealName());
            username.setText(User.getInstance().getUserName());
            department.setText(User.getInstance().getDepartment());
        }
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
