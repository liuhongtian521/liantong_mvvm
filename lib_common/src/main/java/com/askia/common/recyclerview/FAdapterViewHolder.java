/**
 * Copyright 2015 bingoogolapple
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.askia.common.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @ClassName FAdapterViewHolder
 * @author  WangHuanyu
 * @todo 适用于AdapterView的item的ViewHolder
 * @date 2016/9/13 16:16
 */
public class FAdapterViewHolder {
    protected View mConvertView;
    protected FViewHolderHelper mViewHolderHelper;

    private FAdapterViewHolder(ViewGroup parent, int layoutId) {
        mConvertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
        mViewHolderHelper = new FViewHolderHelper(parent, mConvertView);
    }

    /**
     * 拿到一个可重用的ViewHolder对象
     *
     * @param convertView
     * @param parent
     * @param layoutId
     * @return
     */
    public static FAdapterViewHolder dequeueReusableAdapterViewHolder(View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new FAdapterViewHolder(parent, layoutId);
        }
        return (FAdapterViewHolder) convertView.getTag();
    }

    public FViewHolderHelper getViewHolderHelper() {
        return mViewHolderHelper;
    }

    public View getConvertView() {
        return mConvertView;
    }

}