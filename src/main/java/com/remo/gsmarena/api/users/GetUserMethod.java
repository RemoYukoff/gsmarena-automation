package com.remo.gsmarena.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.R;

import java.util.Properties;

public class GetUserMethod extends AbstractApiMethodV2 {
    public GetUserMethod(int id) {
        super(null, "api/users/get/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", R.CONFIG.get("api_url"));
        replaceUrlPlaceholder("access_token", R.CONFIG.get("access_token"));
        replaceUrlPlaceholder("id", String.valueOf(id));
    }
}
