package mekanism.generators.common.content.blocktype;

import static mekanism.common.util.VoxelShapeUtils.setShape;
import static net.minecraft.block.Block.makeCuboidShape;
import mekanism.common.util.EnumUtils;
import mekanism.common.util.VoxelShapeUtils;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;

public final class BlockShapes {

    public static final VoxelShape[] HEAT_GENERATOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] WIND_GENERATOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] BIO_GENERATOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] SOLAR_GENERATOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] GAS_BURNING_GENERATOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] ADVANCED_SOLAR_GENERATOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] CONTROL_ROD_ASSEMBLY = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];
    public static final VoxelShape[] FUEL_ASSEMBLY = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];

    static {
        setShape(VoxelShapeUtils.combine(
              makeCuboidShape(0, 7, 6, 16, 16, 15), // drum
              makeCuboidShape(0, 0, 0, 16, 6, 16), // base
              makeCuboidShape(3, 6, 5, 5, 15, 16), // ring1
              makeCuboidShape(11, 6, 5, 13, 15, 16), // ring2
              makeCuboidShape(0, 6, 2, 16, 16, 5), // back
              makeCuboidShape(3, 6, 1, 5, 15, 2), // bar1
              makeCuboidShape(11, 6, 1, 13, 15, 2), // bar2
              makeCuboidShape(4, 6, 0, 12, 12, 2), // port
              makeCuboidShape(5, 10, -0.005, 11, 11, 0.995), // port_led1
              makeCuboidShape(5, 5, -0.005, 11, 6, 0.995), // port_led2
              makeCuboidShape(10, 6, -0.005, 11, 10, 0.995), // port_led3
              makeCuboidShape(5, 6, -0.005, 6, 10, 0.995), // port_led4
              makeCuboidShape(0, 13, 0, 16, 14, 2), // fin7
              makeCuboidShape(0, 15, 0, 16, 16, 2), // fin8
              makeCuboidShape(0, 11, 0, 4, 12, 2), // fin1
              makeCuboidShape(0, 9, 0, 4, 10, 2), // fin2
              makeCuboidShape(0, 7, 0, 4, 8, 2), // fin3
              makeCuboidShape(12, 11, 0, 16, 12, 2), // fin4
              makeCuboidShape(12, 9, 0, 16, 10, 2), // fin5
              makeCuboidShape(12, 7, 0, 16, 8, 2) // fin6
        ), HEAT_GENERATOR);

        setShape(VoxelShapeUtils.combine(
              makeCuboidShape(4.5, 68.5, 4, 11.5, 75.5, 13),
              makeCuboidShape(5, 5, 1, 11, 11, 11),
              makeCuboidShape(6, 3, 2.5, 10, 5, 4.5),
              makeCuboidShape(4, 4, 0, 12, 12, 1),
              makeCuboidShape(2, 1, 2, 14, 3, 14),
              makeCuboidShape(0, 0, 0, 16, 2, 16),
              makeCuboidShape(5.5, 68.5, 13, 10.5, 74.82, 14.3),
              makeCuboidShape(5.5, 68.75, 14.3, 10.5, 74.1, 14.9),
              makeCuboidShape(6.5, 68.8, 14.9, 9.5, 73.8, 15.3),
              makeCuboidShape(6.5, 69, 15.3, 9.5, 72, 15.6),
              makeCuboidShape(6.5, 69, 15.6, 9.5, 70.3, 16),
              makeCuboidShape(5.25, 67, 5.25, 10.75, 70, 10.75),
              makeCuboidShape(5, 59, 5, 11, 67, 11),
              makeCuboidShape(4.75, 51, 4.75, 11.25, 59, 11.25),
              makeCuboidShape(4.5, 43, 4.5, 11.5, 51, 11.5),
              makeCuboidShape(4.25, 35, 4.25, 11.75, 43, 11.75),
              makeCuboidShape(4, 27, 4, 12, 35, 12),
              makeCuboidShape(3.75, 19, 3.75, 12.25, 27, 12.25),
              makeCuboidShape(3.5, 11, 3.5, 12.5, 19, 12.5),
              makeCuboidShape(3.25, 15, 3.25, 12.75, 19, 12.75),
              makeCuboidShape(3, 3, 3, 13, 15, 13)
        ), WIND_GENERATOR);

        setShape(VoxelShapeUtils.translate(VoxelShapeUtils.combine(
              makeCuboidShape(6, -4, 6, 10, 25, 10), // pole
              makeCuboidShape(4, 22, 2, 6, 24, 14), // tube1
              makeCuboidShape(10, 22, 2, 12, 24, 14), // tube2
              makeCuboidShape(4, 25, 5, 12, 31, 11), // barrel
              makeCuboidShape(5, 24, 4, 6, 32, 12), // ring1
              makeCuboidShape(10, 24, 4, 11, 32, 12), // ring2
              makeCuboidShape(5, -11, 1, 11, -5, 4), // connector
              makeCuboidShape(0, -16, 0, 16, -14, 16), // base
              makeCuboidShape(3, -14, 3, 13, -12, 13), // base2
              makeCuboidShape(4, -12, 4, 12, -4, 12), // base3
              makeCuboidShape(4, -12, 0, 12, -4, 1), // port
              makeCuboidShape(5, -6, -0.005, 11, -5, -0.005), // port_led1
              makeCuboidShape(5, -11, -0.005, 11, -10, -0.005), // port_led2
              makeCuboidShape(10, -10, -0.005, 11, -6, -0.005), // port_led3
              makeCuboidShape(5, -10, -0.005, 6, -6, -0.005), // port_led4
              makeCuboidShape(14, 30, -16, 32, 31, 32), // solar_panel_east
              makeCuboidShape(15, 29, -15, 31, 30, 31), // solar_panel_east_base
              makeCuboidShape(12, 27, 7, 28, 29, 9), // solar_panel_east_arm
              makeCuboidShape(-16, 30, -16, 2, 31, 32), // solar_panel_west
              makeCuboidShape(-15, 29, -15, 1, 30, 31), // solar_panel_west_base
              makeCuboidShape(-12, 27, 7, 4, 29, 9) // solar_panel_west_arm
        ), new Vector3d(0, 1, 0)), ADVANCED_SOLAR_GENERATOR);

        setShape(VoxelShapeUtils.rotate(VoxelShapeUtils.combine(
              makeCuboidShape(0, 0, 0, 16, 7, 16), // base
              makeCuboidShape(3, 14.01, 0.99, 13, 15.01, 1.99), // bar
              makeCuboidShape(13, 7, 0, 16, 16, 8), // sideRight
              makeCuboidShape(0, 7, 0, 3, 16, 8), // sideLeft
              makeCuboidShape(0, 7, 8, 16, 16, 16), // back
              makeCuboidShape(10, 6, 16.005, 11, 10, 16.005), // port_led4
              makeCuboidShape(5, 6, 16.005, 6, 10, 16.005), // port_led3
              makeCuboidShape(5, 5, 16.005, 11, 6, 16.005), // port_led2
              makeCuboidShape(5, 10, 16.005, 11, 11, 16.005), // port_led1
              makeCuboidShape(2, 7, 1, 14, 15, 8) // glass
        ), Rotation.CLOCKWISE_180), BIO_GENERATOR);

        setShape(VoxelShapeUtils.combine(
              makeCuboidShape(0, 6, 0, 16, 8, 16), // solarPanel
              makeCuboidShape(4, 0, 4, 12, 1, 12), // solarPanelPort
              makeCuboidShape(6, 4, 6, 10, 6, 10), // solarPanelConnector
              makeCuboidShape(7, 2, 7, 9, 4, 9), // solarPanelRod1
              makeCuboidShape(5, 1, 5, 6, 5, 6), // solarPanelRod2
              makeCuboidShape(10, 1, 5, 11, 5, 6), // solarPanelRod3
              makeCuboidShape(5, 1, 10, 6, 5, 11), // solarPanelRod3
              makeCuboidShape(10, 1, 10, 11, 5, 11), // solarPanelRod4
              makeCuboidShape(6, 1, 6, 10, 2, 10), // solarPanelPipeBase
              makeCuboidShape(1, 5, 1, 15, 6, 15) // solarPanelBottom
        ), SOLAR_GENERATOR);

        setShape(VoxelShapeUtils.combine(
              makeCuboidShape(4, 12, 13, 12, 13, 14), // port_connector_south1
              makeCuboidShape(4, 11.3536, 12.6464, 12, 12.8536, 13.6464), // port_connector_south2
              makeCuboidShape(0.5, 12, 4, 2, 13, 12), // port_connector_west1
              makeCuboidShape(2, 12, 4, 3, 13, 12), // port_connector_west2
              makeCuboidShape(1, 5, 4, 2, 5, 12), // bottom_connector1
              makeCuboidShape(4, 5, 14, 12, 5, 15), // bottom_connector2
              makeCuboidShape(14, 5, 4, 15, 5, 12), // bottom_connector3
              makeCuboidShape(4, 5, 1, 12, 5, 2), // bottom_connector4
              makeCuboidShape(4, 12, 2, 12, 13, 3), // port_connector_north1
              makeCuboidShape(4, 10.6464, 2.0607, 12, 12.1464, 3.0607), // port_connector_north2
              makeCuboidShape(12.8431, 17.0858, 4, 14.3431, 18.0858, 12), // port_connector_east1
              makeCuboidShape(13, 12, 4, 14, 13, 12), // port_connector_east2
              makeCuboidShape(3, 6, 3, 13, 16, 13), // chamber
              makeCuboidShape(12, 5, 1, 15, 14, 4), // tank1
              makeCuboidShape(1, 5, 1, 4, 14, 4), // tank4
              makeCuboidShape(1, 5, 12, 4, 14, 15), // tank3
              makeCuboidShape(12, 5, 12, 15, 14, 15), // tank2
              makeCuboidShape(0, 0, 0, 16, 4, 16), // base
              makeCuboidShape(2, 4, 2, 14, 5, 14), // base_platform
              makeCuboidShape(4, 4, 0, 12, 12, 1), // port_north
              makeCuboidShape(5, 10, -0.005, 11, 11, -0.005), // port_north_led1
              makeCuboidShape(5, 5, -0.005, 11, 6, -0.005), // port_north_led2
              makeCuboidShape(10, 6, -0.005, 11, 10, -0.005), // port_north_led3
              makeCuboidShape(5, 6, -0.005, 6, 10, -0.005), // port_north_led4
              makeCuboidShape(15, 4, 4, 16, 12, 12), // port_east
              makeCuboidShape(15.005, 10, 5, 16.005, 11, 11), // port_east_led1
              makeCuboidShape(15.005, 5, 5, 16.005, 6, 11), // port_east_led2
              makeCuboidShape(15.005, 6, 10, 16.005, 10, 11), // port_east_led3
              makeCuboidShape(15.005, 6, 5, 16.005, 10, 6), // port_east_led4
              makeCuboidShape(4, 15.005, 4, 12, 16.005, 12), // port_up
              makeCuboidShape(5, 15.01, 5, 6, 16.01, 11), // port_up_led1
              makeCuboidShape(6, 15.01, 10, 10, 16.01, 11), // port_up_led2
              makeCuboidShape(6, 15.01, 5, 10, 16.01, 6), // port_up_led3
              makeCuboidShape(10, 15.01, 5, 11, 16.01, 11), // port_up_led2
              makeCuboidShape(4, 4, 15, 12, 12, 16), // port_south
              makeCuboidShape(5, 10, 16.005, 11, 11, 16.005), // port_south_led1
              makeCuboidShape(5, 5, 16.005, 11, 6, 16.005), // port_south_led2
              makeCuboidShape(5, 6, 16.005, 6, 10, 16.005), // port_south_led3
              makeCuboidShape(10, 6, 16.005, 11, 10, 16.005), // port_south_led4
              makeCuboidShape(0, 4, 4, 1, 12, 12), // port_west
              makeCuboidShape(-0.005, 10, 5, -0.005, 11, 11), // port_west_led1
              makeCuboidShape(-0.005, 5, 5, -0.005, 6, 11), // port_west_led2
              makeCuboidShape(-0.005, 6, 5, -0.005, 10, 6), // port_west_led3
              makeCuboidShape(-0.005, 6, 10, -0.005, 10, 11) // port_west_led4
        ), GAS_BURNING_GENERATOR);

        setShape(VoxelShapeUtils.combine(
              makeCuboidShape(9, 6, 5, 10, 13, 6), // connector_small_1
              makeCuboidShape(10, 6, 9, 11, 13, 10), // connector_small_2
              makeCuboidShape(6, 6, 10, 7, 13, 11), // connector_small_3
              makeCuboidShape(5, 6, 6, 6, 13, 7), // connector_small_4
              makeCuboidShape(3, 7, 3, 5, 16, 5), // connector_1
              makeCuboidShape(11, 7, 3, 13, 16, 5), // connector_2
              makeCuboidShape(11, 7, 11, 13, 16, 13), // connector_3
              makeCuboidShape(3, 7, 11, 5, 16, 13), // connector_4
              makeCuboidShape(1, 0, 1, 2, 7, 2), // rod_1
              makeCuboidShape(1, 0, 3, 2, 7, 4), // rod_2
              makeCuboidShape(1, 0, 5, 2, 7, 6), // rod_3
              makeCuboidShape(1, 0, 7, 2, 7, 8), // rod_4
              makeCuboidShape(1, 0, 9, 2, 7, 10), // rod_5
              makeCuboidShape(1, 0, 11, 2, 7, 12), // rod_6
              makeCuboidShape(1, 0, 13, 2, 7, 14), // rod_7
              makeCuboidShape(2, 0, 14, 3, 7, 15), // rod_8
              makeCuboidShape(4, 0, 14, 5, 7, 15), // rod_9
              makeCuboidShape(6, 0, 14, 7, 7, 15), // rod_10
              makeCuboidShape(8, 0, 14, 9, 7, 15), // rod_11
              makeCuboidShape(10, 0, 14, 11, 7, 15), // rod_12
              makeCuboidShape(12, 0, 14, 13, 7, 15), // rod_13
              makeCuboidShape(14, 0, 14, 15, 7, 15), // rod_14
              makeCuboidShape(14, 0, 12, 15, 7, 13), // rod_15
              makeCuboidShape(14, 0, 10, 15, 7, 11), // rod_16
              makeCuboidShape(14, 0, 8, 15, 7, 9), // rod_17
              makeCuboidShape(14, 0, 6, 15, 7, 7), // rod_18
              makeCuboidShape(14, 0, 4, 15, 7, 5), // rod_19
              makeCuboidShape(14, 0, 2, 15, 7, 3), // rod_20
              makeCuboidShape(13, 0, 1, 14, 7, 2), // rod_21
              makeCuboidShape(11, 0, 1, 12, 7, 2), // rod_22
              makeCuboidShape(9, 0, 1, 10, 7, 2), // rod_23
              makeCuboidShape(7, 0, 1, 8, 7, 2), // rod_24
              makeCuboidShape(5, 0, 1, 6, 7, 2), // rod_25
              makeCuboidShape(3, 0, 1, 4, 7, 2), // rod_26
              makeCuboidShape(2, 1, 2, 14, 7, 14), // core
              makeCuboidShape(13, 9, 0, 16, 14, 2), // control_rod_frame1
              makeCuboidShape(0, 9, 2, 2, 14, 3), // control_rod_frame1a
              makeCuboidShape(13, 9, 14, 16, 14, 16), // control_rod_frame2
              makeCuboidShape(14, 9, 13, 16, 14, 14), // control_rod_frame2a
              makeCuboidShape(0, 9, 0, 3, 14, 2), // control_rod_frame3
              makeCuboidShape(14, 9, 2, 16, 14, 3), // control_rod_frame3a
              makeCuboidShape(0, 9, 14, 3, 14, 16), // control_rod_frame4
              makeCuboidShape(0, 9, 13, 2, 14, 14), // control_rod_frame4a
              makeCuboidShape(0, 7, 0, 16, 9, 2), // control_rod_frame5
              makeCuboidShape(0, 14, 0, 16, 16, 2), // control_rod_frame6
              makeCuboidShape(0, 7, 2, 2, 9, 14), // control_rod_frame7
              makeCuboidShape(0, 14, 2, 2, 16, 14), // control_rod_frame8
              makeCuboidShape(14, 7, 2, 16, 9, 14), // control_rod_frame9
              makeCuboidShape(14, 14, 2, 16, 16, 14), // control_rod_frame10
              makeCuboidShape(0, 7, 14, 16, 9, 16), // control_rod_frame11
              makeCuboidShape(0, 14, 14, 16, 16, 16), // control_rod_frame12
              makeCuboidShape(15, 0, 1, 16, 3, 15), // rod_brace_east
              makeCuboidShape(0, 0, 1, 1, 3, 15), // rod_brace_west
              makeCuboidShape(0, 0, 15, 16, 3, 16), // rod_brace_south
              makeCuboidShape(0, 0, 0, 16, 3, 1), // rod_brace_north
              makeCuboidShape(1, 0, 1, 15, 1, 15) // rod_brace_plate1
        ), CONTROL_ROD_ASSEMBLY);

        setShape(VoxelShapeUtils.combine(
              makeCuboidShape(2, 0, 2, 14, 14, 14), // core
              makeCuboidShape(13, 1, 1, 14, 16, 2), // rod_1
              makeCuboidShape(11, 1, 1, 12, 16, 2), // rod_2
              makeCuboidShape(9, 1, 1, 10, 16, 2), // rod_3
              makeCuboidShape(7, 1, 1, 8, 16, 2), // rod_4
              makeCuboidShape(5, 1, 1, 6, 16, 2), // rod_5
              makeCuboidShape(3, 1, 1, 4, 16, 2), // rod_6
              makeCuboidShape(1, 1, 1, 2, 16, 2), // rod_7
              makeCuboidShape(1, 1, 3, 2, 16, 4), // rod_8
              makeCuboidShape(1, 1, 5, 2, 16, 6), // rod_9
              makeCuboidShape(1, 1, 7, 2, 16, 8), // rod_10
              makeCuboidShape(1, 1, 9, 2, 16, 10), // rod_11
              makeCuboidShape(1, 1, 11, 2, 16, 12), // rod_12
              makeCuboidShape(1, 1, 13, 2, 16, 14), // rod_13
              makeCuboidShape(2, 1, 14, 3, 16, 15), // rod_14
              makeCuboidShape(4, 1, 14, 5, 16, 15), // rod_15
              makeCuboidShape(6, 1, 14, 7, 16, 15), // rod_16
              makeCuboidShape(8, 1, 14, 9, 16, 15), // rod_17
              makeCuboidShape(10, 1, 14, 11, 16, 15), // rod_18
              makeCuboidShape(12, 1, 14, 13, 16, 15), // rod_19
              makeCuboidShape(14, 1, 14, 15, 16, 15), // rod_20
              makeCuboidShape(14, 1, 12, 15, 16, 13), // rod_21
              makeCuboidShape(14, 1, 10, 15, 16, 11), // rod_22
              makeCuboidShape(14, 1, 8, 15, 16, 9), // rod_23
              makeCuboidShape(14, 1, 6, 15, 16, 7), // rod_24
              makeCuboidShape(14, 1, 4, 15, 16, 5), // rod_25
              makeCuboidShape(14, 1, 2, 15, 16, 3), // rod_26
              makeCuboidShape(12, 15, 2, 13, 16, 3), // rod_27
              makeCuboidShape(12, 15, 7, 13, 17, 8), // rod_28
              makeCuboidShape(9, 15, 10, 10, 16, 11), // rod_29
              makeCuboidShape(6, 15, 12, 7, 17, 13), // rod_30
              makeCuboidShape(6, 15, 6, 7, 17, 7), // rod_31
              makeCuboidShape(6, 15, 4, 7, 16, 5), // rod_32
              makeCuboidShape(4, 15, 3, 5, 17, 4), // rod_33
              makeCuboidShape(3, 15, 10, 4, 16, 11), // rod_34
              makeCuboidShape(1, 14, 1, 15, 15, 15), // rod_brace_plate3
              makeCuboidShape(15, 13, 1, 16, 16, 15), // rod_brace_east
              makeCuboidShape(0, 13, 1, 1, 16, 15), // rod_brace_west
              makeCuboidShape(0, 13, 15, 16, 16, 16), // rod_brace_south
              makeCuboidShape(0, 13, 0, 16, 16, 1), // rod_brace_north
              makeCuboidShape(1, 13, 1, 15, 14, 15), // rod_brace_plate2
              makeCuboidShape(1, 0, 1, 15, 1, 15), // rod_brace_plate2
              makeCuboidShape(15, 0, 1, 16, 3, 15), // base_wall_east
              makeCuboidShape(0, 0, 1, 1, 3, 15), // base_wall_west
              makeCuboidShape(0, 0, 0, 16, 3, 1), // base_wall_north
              makeCuboidShape(0, 0, 15, 16, 3, 16) // base_wall_south
        ), FUEL_ASSEMBLY);
    }
}
