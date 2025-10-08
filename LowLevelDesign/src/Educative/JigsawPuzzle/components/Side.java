package Educative.JigsawPuzzle.components;

import Educative.JigsawPuzzle.enums.Edge;

public class Side {
    private Edge edge;
    private int curvatureId; // Unique id to match INDENTATION/EXTRUSION pairs

    public Side(Edge edge, int curvatureId) {
        this.edge = edge;
        this.curvatureId = curvatureId;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public int getCurvatureId() {
        return curvatureId;
    }

    public void setCurvatureId(int curvatureId) {
        this.curvatureId = curvatureId;
    }

    // Returns true if this side fits with another side
    public boolean fitsWith(Side other) {
        if (this.edge == Edge.FLAT || other.edge == Edge.FLAT) return false;
        // One must be INDENTATION, other EXTRUSION, and curvatureId must match
        return ((this.edge == Edge.INDENTATION && other.edge == Edge.EXTRUSION) ||
                (this.edge == Edge.EXTRUSION && other.edge == Edge.INDENTATION)) &&
                this.curvatureId == other.curvatureId;
    }
}
