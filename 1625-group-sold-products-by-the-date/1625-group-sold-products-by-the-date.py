import pandas as pd

def categorize_products(activities: pd.DataFrame) -> pd.DataFrame:
    
    df = activities.groupby('sell_date').agg(
        num_sold = ('product','nunique'),
        products = ('product',  lambda x: ','.join(sorted(set(x))))  # Sort and join unique product names
    ).reset_index()
    
    return df