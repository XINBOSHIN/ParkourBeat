package ru.sortix.parkourbeat.levels.dao.files;

import org.bukkit.configuration.file.FileConfiguration;
import ru.sortix.parkourbeat.levels.settings.GameSettings;

public class GameSettingsDAO {

    public void set(GameSettings gameSettings, FileConfiguration config) {
        config.set("song_play_list_name", gameSettings.getSongPlayListName());
        config.set("song_name", gameSettings.getSongName());
    }

    public GameSettings load(FileConfiguration config) {
        String songPlayListName = config.getString("song_play_list_name");
        String songName = config.getString("song_name");
        return new GameSettings(songPlayListName, songName);
    }
}
