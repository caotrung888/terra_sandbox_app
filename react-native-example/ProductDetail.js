import React, { Component } from 'react';
import {
    StyleSheet,
    Text,
    View,
    TouchableOpacity,
    Image,
    ToastAndroid,
    Alert,
    ScrollView,
    FlatList,
    Button,
} from 'react-native';

import '@terra-js/react-native-bridge';
import PaymentKit, { PaymentRequestBuilder } from '@terra-js/payment-kit';
import { MainMethodType } from '@terra-js/payment-kit/dist/constansts';
import TerraKit from '@terra-js/terra-kit';

export default class ProductDetail extends Component {

    constructor(props) {
        super(props);
    }

    clickEventListener() {
        // Alert.alert("Success", "Product has beed added to cart")

        const amount = 150000;

        const paymentRequestBuilder = new PaymentRequestBuilder();
        paymentRequestBuilder
            .setOrder({
                orderCode: "abcd12345",
                orderAmount: amount,
            })
            .setPaymentMethods({
                mainMethod: {
                    method: MainMethodType.All,
                    amount,
                },
                totalAmount: amount,
            })
            .setOptions({
                shouldShowPaymentResultScreen: true,
            });
        PaymentKit.payForOrder(paymentRequestBuilder.build()).then((result) => {
            this.showAlertt(result)
        });
    }

    showAlertt(result) {
        var message = ''

        // switch (result.resultCode) {
        //     case 'succeeded':
        //         Alert.alert("Thông báo", "Thanh toán thành công", [{
        //             text: 'Okay',
        //             onPress: () => {

        //             }, style: 'cancel'
        //         }]);
        //         break;
        //     case 'failed':
        //         Alert.alert("Thông báo", "Thanh toán thất bại");
        //         break;
        //     default:
        //         Alert.alert("Thông báo", "Đơn hàng chưa thanh toán");
        //         break
        // }

        switch (result.resultCode) {
            case 'succeeded':
                message = "Thanh toán thành công";
                break;
            case 'failed':
                Amessage = "Thanh toán thất bại";
                break;
            default:
                message = "Đơn hàng chưa thanh toán";
                break
        }

        ToastAndroid.showWithGravityAndOffset(
            message,
            ToastAndroid.LONG,
            ToastAndroid.BOTTOM,
            25,
            50
        );
    }

    render() {
        return (
            <View style={styles.container}>
                <ScrollView>
                    <View style={{ alignItems: 'center', marginHorizontal: 30 }}>
                        <Image style={styles.productImg} source={{ uri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3v7KDJN7TAoJa5sFaPWcp1HX8JFcpF3z5K3ngz4L6kWoEP7Ca" }} />
                        <Text style={styles.name}>Super Soft T-Shirt</Text>
                        <Text style={styles.price}>$ 12.22</Text>
                        <Text style={styles.description}>
                            Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                            Aenean commodo ligula eget dolor. Aenean massa. Cum sociis
                            natoque penatibus et magnis dis parturient montes,
                            nascetur ridiculus mus. Donec quam felis, ultricies nec
            </Text>
                    </View>
                    <View style={styles.starContainer}>
                        <Image style={styles.star} source={{ uri: "https://img.icons8.com/color/40/000000/star.png" }} />
                        <Image style={styles.star} source={{ uri: "https://img.icons8.com/color/40/000000/star.png" }} />
                        <Image style={styles.star} source={{ uri: "https://img.icons8.com/color/40/000000/star.png" }} />
                        <Image style={styles.star} source={{ uri: "https://img.icons8.com/color/40/000000/star.png" }} />
                        <Image style={styles.star} source={{ uri: "https://img.icons8.com/color/40/000000/star.png" }} />
                    </View>
                    <View style={styles.contentColors}>
                        <TouchableOpacity style={[styles.btnColor, { backgroundColor: "#00BFFF" }]}></TouchableOpacity>
                        <TouchableOpacity style={[styles.btnColor, { backgroundColor: "#FF1493" }]}></TouchableOpacity>
                        <TouchableOpacity style={[styles.btnColor, { backgroundColor: "#00CED1" }]}></TouchableOpacity>
                        <TouchableOpacity style={[styles.btnColor, { backgroundColor: "#228B22" }]}></TouchableOpacity>
                        <TouchableOpacity style={[styles.btnColor, { backgroundColor: "#20B2AA" }]}></TouchableOpacity>
                        <TouchableOpacity style={[styles.btnColor, { backgroundColor: "#FF4500" }]}></TouchableOpacity>
                    </View>

                    <View style={styles.separator}></View>
                    <View style={styles.addToCarContainer}>
                        <TouchableOpacity style={styles.shareButton} onPress={() => this.clickEventListener()}>
                            <Text style={styles.shareButtonText}>Buy Now</Text>
                        </TouchableOpacity>
                    </View>
                </ScrollView>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginTop: 20,
    },
    productImg: {
        width: 200,
        height: 200,
    },
    name: {
        fontSize: 28,
        color: "#696969",
        fontWeight: 'bold'
    },
    price: {
        marginTop: 10,
        fontSize: 18,
        color: "green",
        fontWeight: 'bold'
    },
    description: {
        textAlign: 'center',
        marginTop: 10,
        color: "#696969",
    },
    star: {
        width: 40,
        height: 40,
    },
    btnColor: {
        height: 30,
        width: 30,
        borderRadius: 30,
        marginHorizontal: 3
    },
    btnSize: {
        height: 40,
        width: 40,
        borderRadius: 40,
        borderColor: '#778899',
        borderWidth: 1,
        marginHorizontal: 3,
        backgroundColor: 'white',

        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
    },
    starContainer: {
        justifyContent: 'center',
        marginHorizontal: 30,
        flexDirection: 'row',
        marginTop: 20
    },
    contentColors: {
        justifyContent: 'center',
        marginHorizontal: 30,
        flexDirection: 'row',
        marginTop: 20
    },
    contentSize: {
        justifyContent: 'center',
        marginHorizontal: 30,
        flexDirection: 'row',
        marginTop: 20
    },
    separator: {
        height: 2,
        backgroundColor: "#eeeeee",
        marginTop: 20,
        marginHorizontal: 30
    },
    shareButton: {
        marginTop: 10,
        height: 45,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 30,
        backgroundColor: "#00BFFF",
    },
    shareButtonText: {
        color: "#FFFFFF",
        fontSize: 20,
    },
    addToCarContainer: {
        marginHorizontal: 30
    }
});