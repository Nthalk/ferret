package com.iodesystems.ferret.file;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class FileWatcher extends Thread {

    private int delay = 3;
    private TimeUnit delayUnit = TimeUnit.SECONDS;
    private long lastModified = -1;
    private boolean didWarn = false;

    public abstract File getFile() throws Exception;

    public abstract void onFileChange(File file) throws Exception;

    public abstract void onError(Exception e);

    @Override
    public void run() {
        while (true) {
            try {
                try {
                    File file = getFile();
                    if (didChange(file)) {
                        didWarn = false;
                        onFileChange(file);
                    }
                } catch (Exception e) {
                    if (!didWarn) {
                        didWarn = true;
                        onError(e);
                    }
                }
                Thread.sleep(TimeUnit.MILLISECONDS.convert(delay, delayUnit));
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private boolean didChange(File file) {
        if (!file.exists()) {
            if (lastModified != -1) {
                lastModified = -1;
                return true;
            }
        } else {
            long l = file.lastModified();
            if (l > lastModified) {
                lastModified = l;
                return true;
            }
        }
        return false;
    }
}
