package ru.sortix.parkourbeat.levels.settings;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import ru.sortix.parkourbeat.levels.DirectionChecker;
import ru.sortix.parkourbeat.location.Waypoint;

import java.util.*;

public class WorldSettings {

    private final World world;
    private Location spawn;
    private Vector startBorder;
    private Vector finishBorder;
    private final ArrayList<Waypoint> waypoint;

    public WorldSettings(World world, Location spawn, Vector startRegion, Vector finishRegion, ArrayList<Waypoint> waypoint) {
        this.world = world;
        this.spawn = spawn;
        this.startBorder = startRegion;
        this.finishBorder = finishRegion;
        this.waypoint = waypoint;
    }

    public World getWorld() {
        return world;
    }

    public Location getSpawn() {
        return spawn;
    }

    public ArrayList<Waypoint> getWaypoints() {
        return waypoint;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public Vector getStartBorder() {
        return startBorder;
    }

    public Vector getFinishBorder() {
        return finishBorder;
    }

    public DirectionChecker.Direction getDirection() {
        if (startBorder == null || finishBorder == null) {
            return null;
        }
        if (Math.abs(startBorder.getX() - finishBorder.getX()) > Math.abs(startBorder.getZ() - finishBorder.getZ())) {
            if (startBorder.getX() < finishBorder.getX()) {
                return DirectionChecker.Direction.POSITIVE_X;
            } else {
                return DirectionChecker.Direction.NEGATIVE_X;
            }
        } else {
            if (startBorder.getZ() < finishBorder.getZ()) {
                return DirectionChecker.Direction.POSITIVE_Z;
            } else {
                return DirectionChecker.Direction.NEGATIVE_Z;
            }
        }
    }

    public void setStartBorder(Vector startPoint) {
        this.startBorder = startPoint;
    }

    public void setFinishBorder(Vector finishPoint) {
        this.finishBorder = finishPoint;
    }
}
