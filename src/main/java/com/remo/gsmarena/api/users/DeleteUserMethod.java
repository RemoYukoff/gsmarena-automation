package com.remo.gsmarena.api.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.R;

public class DeleteUserMethod extends AbstractApiMethodV2 {
    public DeleteUserMethod(int id) {
        super(null,"api/users/delete/rs.json");
        replaceUrlPlaceholder("base_url", R.CONFIG.get("api_url"));
        replaceUrlPlaceholder("access_token", R.CONFIG.get("access_token"));
        replaceUrlPlaceholder("id", String.valueOf(id));
    }
}
