package net.osmand.plus.osmedit;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.osmand.plus.R;
import net.osmand.plus.base.MenuBottomSheetDialogFragment;
import net.osmand.plus.base.bottomsheetmenu.BaseBottomSheetItem;
import net.osmand.plus.base.bottomsheetmenu.BottomSheetItemWithDescription;
import net.osmand.plus.base.bottomsheetmenu.simpleitems.DividerHalfItem;
import net.osmand.plus.base.bottomsheetmenu.simpleitems.TitleItem;
import net.osmand.plus.osmedit.OsmEditsFragment.FileTypesDef;

public class FileTypeBottomSheetDialogFragment extends MenuBottomSheetDialogFragment {

	public static final String TAG = "FileTypeBottomSheetDialogFragment";

	private FileTypeFragmentListener listener;

	public void setListener(FileTypeFragmentListener listener) {
		this.listener = listener;
	}

	@Override
	public View createMenuItems(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		items.add(new TitleItem(getString(R.string.choose_file_type)));

		Drawable fileIcon = getContentIcon(R.drawable.ic_type_file);

		BaseBottomSheetItem oscItem = new BottomSheetItemWithDescription.Builder()
				.setDescription(getString(R.string.osc_file_desc))
				.setIcon(fileIcon)
				.setTitle(getString(R.string.osc_file))
				.setLayoutId(R.layout.bottom_sheet_item_with_descr_56dp)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if (listener != null) {
							listener.onClick(OsmEditsFragment.FILE_TYPE_OSC);
						}
						dismiss();
					}
				})
				.create();
		items.add(oscItem);

		items.add(new DividerHalfItem(getContext()));

		BaseBottomSheetItem gpxItem = new BottomSheetItemWithDescription.Builder()
				.setDescription(getString(R.string.gpx_file_desc))
				.setIcon(fileIcon)
				.setTitle(getString(R.string.gpx_file))
				.setLayoutId(R.layout.bottom_sheet_item_with_descr_56dp)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if (listener != null) {
							listener.onClick(OsmEditsFragment.FILE_TYPE_GPX);
						}
						dismiss();
					}
				})
				.create();
		items.add(gpxItem);

		return null;
	}

	public interface FileTypeFragmentListener {

		void onClick(@FileTypesDef int type);
	}
}
