import React from 'react';
import { Provider, connect } from 'react-redux'
import { createStore, combineReducers, bindActionCreators } from 'redux';
import styles from './button.module.css';

import '@terra-js/web-bridge';
import PaymentKit, { PaymentRequestBuilder } from '@terra-js/payment-kit';
import { MainMethodType } from '@terra-js/payment-kit/dist/constansts';
import TerraKit from '@terra-js/terra-kit';

const GET_PRODUCTS = "get_products";
const urlParams = new URLSearchParams(window.location.search);
const token = urlParams.get('terraIdToken');
const scenario = urlParams.get('scenario');
var sitePageTitle = 'Scenario ' + scenario;


/** REDUX STORE **/
let getProducts = function (products, oldProducts) {
    let newProducts;

    products == oldProducts
        ? (newProducts = oldProducts)
        : (newProducts = products);

    return {
        type: GET_PRODUCTS,
        payload: newProducts
    };
};


class ProductPage extends React.Component {
    render() {
        return (
            <div
                style={{
                    paddingLeft: '8px',
                    paddingRight: '8px'
                }}
            >
                <PageTitle />
                <ProductGrid />
                <TokenView token={token}/>
            </div>
        );
    }
}

/** PAGE **/
class PageTitle extends React.Component {
    constructor(props) {
        super(props);
        this.state = { title: sitePageTitle };
    }
    render() {
        return (
            <div className="text-center">
                <h2>{this.state.title}</h2>
                <hr />
            </div>
        );
    }
}

/** PRODUCTS **/
class ProductGrid extends React.Component {
    constructor(props) {
        super(props);
        this.state = { products: [] };
    }

    componentDidMount() {
        const product = {
            key: 1,
            title: '',
            description: '',
            url: ''
        }

        const products = [product];

        this.setState({ products });
    }

    render() {
        let createProducts = this.state.products.map(function iterator(product) {
            return <Product {...product} />;
        });

        return (
            <div className="grid-x grid-margin-x small-up-2 medium-up-2 large-up-4">
                {createProducts}
            </div>
        );
    }
}

const Button = ({ children, onClick, btnColor = 'teal', labelColor, disabled, type, style, ...props }) => {
    const commonStyles = {
        backgroundColor: btnColor,
        color: labelColor || 'white'
    };
    const outlineStyles = {
        border: `1px solid ${btnColor}`,
        color: btnColor,
        backgroundColor: 'white'
    };
    const outlineHoverStyle = {
        color: labelColor || 'white',
        backgroundColor: btnColor
    };

    const roundedStyle = {
        backgroundColor: btnColor,
        color: labelColor || 'white',
        borderRadius: '25px'
    };
    const disabledStyle = {
        cursor: 'default',
        backgroundColor: btnColor,
        color: labelColor || 'white',
        opacity: 0.4
    };
    const blockStyles = {
        width: '95%',
        margin: '0 auto'
    };
    let btnStyle;
    switch (type) {
        case 'rounded':
            btnStyle = roundedStyle;
            break;
        case 'block':
            btnStyle = blockStyles;
            break;
        case 'outline':

            break;
        default:
            btnStyle = {
                backgroundColor: btnColor,
                color: labelColor || 'white'
            };
            break;
    }
    return (
        <button
            style={

                disabled ? { ...commonStyles, ...btnStyle, ...disabledStyle, ...style } :
                    { ...commonStyles, ...btnStyle, ...style }
            }

            {...props}
            type="button"
            onClick={

                !disabled ? onClick :
                    () => { }
            }
            className={styles.btn}
        >
            {children || 'button'}
        </button>
    );
};

class Product extends React.Component {

    render() {
        const { title, description, url } = this.props;

        function pay() {
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
                switch (result.resultCode) {
                    case 'succeeded':
                        alert("Thanh toán thành công");
                        break;
                    case 'failed':
                        alert("Thanh toán thất bại");
                        break;
                    case 'canceled':
                        alert("Đơn hàng chưa được thanh toán");
                        break;
                }
            });
        }

        const headerColor = {
            justifyContent: "left",
            alignItems: "center",
            padding: '4px'
        }


        return (
            <div style={headerColor} className="cell">
                <img s style={{ width: 360 }} src="https://binhminhdigital.com/StoreData/Product/8814/TAI-NGHE-AUDIOPHILE-SENNHEISER-HD-579%20(1).jpg" />
                <h4>Sennheiser HD 579 – Something You May Like It</h4>
                <h4>Price: 200$</h4>
                <Button onClick={pay}>Buy Now</Button>
            </div>
        );
    }
}

const TokenView = ({ token }) => {
    return <div >
        <h3>Token:</h3>
        <p style={{overflowWrap: "break-word"}}>{token}</p>
    </div>
}

export default ProductPage;