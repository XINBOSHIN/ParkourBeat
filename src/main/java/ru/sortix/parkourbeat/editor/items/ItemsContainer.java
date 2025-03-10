package ru.sortix.parkourbeat.editor.items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.sortix.parkourbeat.game.GameManager;
import ru.sortix.parkourbeat.levels.Level;

import java.util.HashMap;
import java.util.Map;

public class ItemsContainer {

    private final Map<ItemStack, EditorItem> editorItems;
    private final Player player;

    public ItemsContainer(Player player, Level level, GameManager gameManager) {
        this.player = player;
        editorItems = new HashMap<>();
        ParticleItem particleItem = new ParticleItem(player, level);
        StartFinishItem startFinishItem = new StartFinishItem(player, level);
        SpawnItem spawnItem = new SpawnItem(player, level);
        TestItem testItem = new TestItem(player, level, gameManager, this);

        editorItems.put(particleItem.getItemStack(), particleItem);
        editorItems.put(startFinishItem.getItemStack(), startFinishItem);
        editorItems.put(spawnItem.getItemStack(), spawnItem);
        editorItems.put(testItem.getItemStack(), testItem);
    }

    public void giveToPlayer() {
        for (EditorItem item : editorItems.values()) {
            player.getInventory().setItem(item.getSlot(), item.getItemStack());
        }
    }

    public Map<ItemStack, EditorItem> getEditorItems() {
        return editorItems;
    }

    public void updateEditorItem(ItemStack prevItem, ItemStack newItem) {
        EditorItem editorItem = editorItems.remove(prevItem);
        editorItems.put(newItem, editorItem);
    }

}
