import pandas as pd

def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    customer_counts = orders.groupby('customer_number').size().reset_index(name='count')
    sorted_customers = customer_counts.sort_values(by='count', ascending=False)
    most_frequent_customer = sorted_customers.head(1)[['customer_number']]
    return most_frequent_customer