package org.energyos.espi.datacustodian.web.api;
/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import com.sun.syndication.io.FeedException;
import org.energyos.espi.datacustodian.domain.UsagePoint;
import org.energyos.espi.datacustodian.models.atom.EntryType;
import org.energyos.espi.datacustodian.models.atom.FeedType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBuilder {
    private FeedType feed;

    public FeedType build(List<UsagePoint> usagePointList) throws FeedException {
        feed = new FeedType();

        populateEntries(usagePointList);

        return feed;
    }

    private void populateEntries(List<UsagePoint> usagePointList) throws FeedException {
        for (UsagePoint usagePoint : usagePointList) {
            feed.getEntries().add(new EntryBuilder().build(usagePoint));
        }
    }

    public EntryType buildEntry(UsagePoint usagePoint) {
        return new EntryBuilder().build(usagePoint);
    }
}
