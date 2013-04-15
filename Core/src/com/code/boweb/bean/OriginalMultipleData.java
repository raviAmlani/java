package com.code.boweb.bean;

import java.util.ArrayList;



/*<OMD >
<!--Can be multiple-->
<OMDName object=""  literal ="">consultaAux</OMDName>
<number object="" literal ="">numBonosHappy</number>
<Record>
  <OMDField object="" literal ="codBono">codBono</OMDField>
  <OMDField object="" literal ="desBono">desBono</OMDField>
  <OMDField object="" literal ="costeBono">costeBono</OMDField>
  <!--Can be multiple-->
</Record>
</OMD>*/


public class OriginalMultipleData 
{
	
	
	public ArrayList<OmdData> omdDataList ;

	/**
	 * @return the omdDataList
	 */
	public ArrayList<OmdData> getOmdDataList() {
		return omdDataList;
	}

	/**
	 * @param omdDataList the omdDataList to set
	 */
	public void setOmdDataList(ArrayList<OmdData> omdDataList) {
		this.omdDataList = omdDataList;
	}

	
}

