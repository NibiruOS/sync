package org.nibiru.sync.core.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.nibiru.sync.core.impl.model.DirectoryImpl;
import org.nibiru.sync.core.impl.model.ProjectImpl;
import org.nibiru.sync.core.impl.model.ProjectValue;

import static org.junit.Assert.assertEquals;

public class RemoteSyncTest {
    private static String PROJECT_NAME = "Eipipimeiker";
    private static String ROOT_NAME = "/";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void matanga() throws Exception {
        ProjectValue source = new ProjectValue();

        ModelUpdaterImpl updater = new ModelUpdaterImpl();
        ModelListenerImpl listener = new ModelListenerImpl(new LocalToRemoteUpdater(new RemoteToLocalUpdater(updater)));
        listener.listen(source);

        source.set(new ProjectImpl());

        source.get().setName(PROJECT_NAME);

        source.get().setRoot(new DirectoryImpl());
        source.get().getRoot().setName(ROOT_NAME);

        ProjectValue target = updater.getRoot();

        assertEquals(PROJECT_NAME, target.get().getName());
        assertEquals(ROOT_NAME, target.get().getRoot().getName());
    }
}
