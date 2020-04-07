package com.remo.gsmarena.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.R;

public class PostUserMethod extends AbstractApiMethodV2 {
    public PostUserMethod() {
        super("api/users/post/rq.json","api/users/post/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", R.CONFIG.get("api_url"));
        replaceUrlPlaceholder("access_token", R.CONFIG.get("access_token"));
    }
}
