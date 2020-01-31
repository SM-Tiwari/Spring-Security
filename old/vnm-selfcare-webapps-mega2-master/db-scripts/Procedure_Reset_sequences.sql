procedure Reset_Sequence( p_seq_name in varchar2, p_val in number default 0)
is
  l_current number := 0;
  l_difference number := 0;
  l_minvalue user_sequences.min_value%type := 0;

begin

  select min_value
  into l_minvalue
  from user_sequences
  where sequence_name = p_seq_name;

  execute immediate
  'select ' || p_seq_name || '.nextval from dual' INTO l_current;

  if p_Val < l_minvalue then
    l_difference := l_minvalue - l_current;
  else
    l_difference := p_Val - l_current;
  end if;

  if l_difference = 0 then
    return;
  end if;

  execute immediate
    'alter sequence ' || p_seq_name || ' increment by ' || l_difference ||
       ' minvalue ' || l_minvalue;

  execute immediate
    'select ' || p_seq_name || '.nextval from dual' INTO l_difference;

  execute immediate
    'alter sequence ' || p_seq_name || ' increment by 1 minvalue ' || l_minvalue;
end Reset_Sequence;


create or replace
procedure Reset_Sequence_to_Data(
  p_TableName varchar2,
  p_FieldName varchar2
)
is
  l_MaxUsed NUMBER;
BEGIN

  execute immediate
    'select coalesce(max(' || p_FieldName || '),0) from '|| p_TableName into l_MaxUsed;

  Reset_Sequence( p_TableName || '_' || p_Fieldname || '_SEQ', l_MaxUsed );

END Reset_Sequence_to_Data;


create or replace
procedure Reset_All_Sequences
is
BEGIN

  Reset_Sequence_to_Data( 'ACTIVITYLOG', 'LOGID' );
  Reset_Sequence_to_Data( 'JOBSTATE', 'JOBID' );
  Reset_Sequence_to_Data( 'BATCH', 'BATCHID' );

END Reset_All_Sequences;
