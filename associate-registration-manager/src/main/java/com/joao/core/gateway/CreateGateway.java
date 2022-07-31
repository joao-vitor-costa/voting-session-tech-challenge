package com.joao.core.gateway;

import com.joao.core.domain.AssociateDomain;

public interface CreateGateway {

    AssociateDomain create(AssociateDomain associateDomain);

    AssociateDomain findById(String id);
}
