# 以往的方式（针对ListVIew的适配器）：ViewHolder类，是各种控件的引用，converView.setTag(holder)去存储holder，
万能适配器其实是对继承BaseAdapter的适配器的一个封装
第一步：封装ViewHolder：
  SparseArray容器是一个map，key是int，value是View.
  1.拿到ViewHolder对象holder
  2.通过holder找到控件 holder.getView(viewId)
  3.对控件的操作
  
   public ViewHolder(Context context, ViewGroup parent, int layoutId, int position){
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConvertView.setTag(this);
    }
  
    判断Viewholder是否为复用的
    public static ViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId,int position){
        if(convertView == null){
            return  new ViewHolder(context,parent,layoutId,position);
        }else{
           ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;//position复用的，需要进行更新
            return  holder;
        }
    }
    
    公布一个convertView方法
     public View getConvertView(){
        return mConvertView;
    }

    通过viewId获取控件
    public <T extends  View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return  (T)view;
    }
    
    可以根据需要自己补充控件的操作：
    设置TextView的值
    public ViewHolder setText(int viewId,String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }...
    
第二步：CommonAdapter抽象类,继承BaseAdapter，抽取相同的方法

第三步:使用

注意：
万能适配器：
  解决焦点问题：
	方法一：在根布局中android:descendantFocusability="blocksDescendants"
	方法二：在具有焦点控件中 android:focusable="false"
  	
   因为布局复用的原因，以CheckBox为例，第一个选中的话，复用的部分的checkBox也会处于选中状态，解决方法：
	方法一：如果在实体中有一个标记isCheck，在适配中只需要：
		final CheckBox cb = holder.getView(R.id.cb);
                cb.setChecked(bean.isCheck());
                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bean.setChecke(cb.isChecked());
                    }
                });
	 方法二：通过集合，在适配器中：
		 private List<Integer> mPos = new ArrayList<Integer>();

  		 final CheckBox cb = holder.getView(R.id.cb);
                 cb.setChecked(bean.isChecke());

                 cb.setChecked(false);
                 if(mPos.contains(holder.getmPosition())){
                    cb.setChecked(true);
                 }
                 cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(cb.isChecked()){
                            mPos.add(holder.getmPosition());
                        }else{
                            mPos.remove((Integer) holder.getmPosition());
                        }

                    }
                });


RecyclerView同理


