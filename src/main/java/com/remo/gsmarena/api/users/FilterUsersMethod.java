package com.remo.gsmarena.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.R;

import java.util.Map;
import java.util.Map.Entry;

public class FilterUsersMethod extends AbstractApiMethodV2 {
    public FilterUsersMethod(Map<String,String> params) {
        super(null, null);
        replaceUrlPlaceholder("base_url", R.CONFIG.get("api_url"));
        replaceUrlPlaceholder("access_token", R.CONFIG.get("access_token"));
        String chainParams = "";
        for(Entry<String,String> entry: params.entrySet()){
            chainParams = chainParams.concat(entry.getKey()+"="+entry.getValue()+"&");
        }
        replaceUrlPlaceholder("params",chainParams);
    }
}
