
# input data is in MAD 1983 UTM Zone 11N coordinate system 
input_features = r"C:/data/Redlands.shp"

# output data
output_feature_class = r"C:/data/Redlands_Project.shp"

# Create a spatial reference object for the output coordinate system
out_coordinate_system = arcpy.SpatialReference('NAD 1983 StatePlane California V FIPS 0405 (US Feet)')

# run the tool
arcpy.Project_management(input_features, output_feature_class, out_coordinate_system)

