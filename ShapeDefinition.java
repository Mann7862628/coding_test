package com.java.practice;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShapeDefinition {

    private static Map<String, String> shapeDefinitions = new HashMap<>();

    static {
        // Adding shape definitions to the database
        shapeDefinitions.put("square", "The square is a highly symmetric object. There are four lines of reflectional symmetry and it has rotational symmetry of order 4 (through 90°, 180° and 270°).");
        shapeDefinitions.put("rectangle", "In Euclidean plane geometry, a rectangle is a quadrilateral with four right angles. It can also be defined as: an equiangular quadrilateral, since equiangular means that all of its angles are equal; or a parallelogram containing a right angle. A rectangle with four sides of equal length is a square");
        shapeDefinitions.put("circle", "A circle is a shape consisting of all points in a plane that are at a given distance from a given point, the centre. The distance between any point of the circle and the centre is called the radius.");
        shapeDefinitions.put("triangle", "A triangle is a polygon with three corners and three sides, one of the basic shapes in geometry. The corners, also called vertices, are zero-dimensional points while the sides connecting them, also called edges, are one-dimensional line segments. The triangle's interior is a two-dimensional region.");
        shapeDefinitions.put("cube", "In geometry, a cube is a three-dimensional solid object bounded by six square faces, facets, or sides, with three meeting at each vertex. Viewed from a corner, it is a hexagon and its net is usually depicted as a cross. The cube is the only regular hexahedron and is one of the five Platonic solids.");
        // Add more shapes and their definitions as needed
    }

    public static String getShapeDefinition(String shape) {
        // Convert the input to lowercase for case-insensitive matching
        String lowercaseShape = shape.toLowerCase();
        return shapeDefinitions.getOrDefault(lowercaseShape, "Shape definition not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the shape: ");
        String inputShape = scanner.nextLine();

        String definition = getShapeDefinition(inputShape);
        System.out.println("Output: " + definition);
        scanner.close();
    }
}