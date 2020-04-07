package com.remo.gsmarena.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.R;

public class PutUserMethod extends AbstractApiMethodV2 {
    public PutUserMethod(int id) {
        super("api/users/put/rq.json", "api/users/put/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", R.CONFIG.get("api_url"));
        replaceUrlPlaceholder("access_token", R.CONFIG.get("access_token"));
        replaceUrlPlaceholder("id", String.valueOf(id));
    }
}
